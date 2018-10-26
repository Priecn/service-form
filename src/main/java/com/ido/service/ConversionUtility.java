package com.ido.service;

import com.ido.entity.*;
import com.ido.model.VendorWithCompanyDetailsCommand;
import com.ido.repository.CategoryRepository;
import com.ido.repository.ProvinceRepository;
import com.ido.repository.SubCategoryRepository;
import com.ido.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConversionUtility {

    private VendorRepository vendorRepository;
    private ProvinceRepository provinceRepository;
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public ConversionUtility(VendorRepository vendorRepository, ProvinceRepository provinceRepository, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.vendorRepository = vendorRepository;
        this.provinceRepository = provinceRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    protected Vendor ConvertVendorWithCompanyDetailsCommandToVendor(VendorWithCompanyDetailsCommand vendorCommand) {

        Vendor vendor = getVendorFromInputObject(vendorCommand);
        Company company = getCompanyFromInputObject(vendorCommand);

        company.setVendor(vendor);
        vendor.setCompany(company);

        return vendor;
    }


    /***************************UTILITY METHODS*********************************/
    private Address getAddressFromInputObject(VendorWithCompanyDetailsCommand inputObj, Object vendorOrCompany, boolean isHomeAdderss) {
        Address address = null;
        if(isHomeAdderss) {
            address = new HomeAddress();
            ((HomeAddress)address).setVendor((Vendor) vendorOrCompany);
        } else {
            address = new OfficeAddress();
            ((OfficeAddress)address).setCompany((Company) vendorOrCompany);
        }

        address.setAddressLine1(inputObj.getAddress().getAddressLine1());
        address.setAddressLine2(inputObj.getAddress().getAddressLine1());
        address.setCity(inputObj.getAddress().getCity());
        address.setPincode(inputObj.getAddress().getPincode());
        address.setState(inputObj.getAddress().getState());

        /****************GET PROVINCE*****************/
        System.out.println("VendorService:: ProvinceId: "+inputObj.getAddress().getProvinceId());
        Province province = provinceRepository.findById(inputObj.getAddress().getProvinceId()).get();
        System.out.println("ProvinceRepo:: ProvinceId: "+inputObj.getAddress().getProvinceId());
        address.setProvince(province);

        return address;
    }

    private Company getCompanyFromInputObject(VendorWithCompanyDetailsCommand inputObj) {
        Company company = new Company();

        /*********************FETCHING & SETTING CATEGORY***************************/
        BusinessCategory category = categoryRepository
                .findById(inputObj.getCompany().getBusinessCategoryId()).get();
        company.setBusinessCategory(category);

        /*******************FETCHING & SETTING SUB CATEGORY***************************/
        Set<BusinessSubCategory> subCategories = inputObj.getCompany()
                .getSubCategoryIds()
                .stream()
                .map(
                        id -> subCategoryRepository.getOne(id)
                ).collect(Collectors.toSet());

        company.setSubCategories(subCategories);

        company.setAddress((OfficeAddress) getAddressFromInputObject(inputObj, company, false));
        return company;
    }

    private Vendor getVendorFromInputObject(VendorWithCompanyDetailsCommand inputObj) {
        Vendor vendor = new Vendor();
        vendor.setFirstName(inputObj.getFirstName());
        vendor.setLastName(inputObj.getLastName());
        vendor.setDateOfBirth(inputObj.getDateOfBirth());
        vendor.setEmail(inputObj.getEmail());
        vendor.setGender(Gender.valueOf(inputObj.getGender()));
        vendor.setPhoneNumber(inputObj.getPhoneNumber());
        vendor.setMobileNumber(inputObj.getMobileNumber());
        vendor.setVendorRegDate(inputObj.getVendorRegDate());
        vendor.setId(generateVendorId(inputObj));
        vendor.setAddress((HomeAddress) getAddressFromInputObject(inputObj, vendor, true));

        return vendor;
    }

    private Long generateVendorId(VendorWithCompanyDetailsCommand inputObj) {
        int year = inputObj.getVendorRegDate().getYear();
        int homeProvinceId = inputObj.getAddress().getProvinceId();

        String category = String.valueOf(inputObj.getCompany().getBusinessCategoryId());
        int numberOfDigitsInCategoryDiffFrom3 = 3 - category.length();
        if(numberOfDigitsInCategoryDiffFrom3 == 2)
            category = "00" + category;
        else if(numberOfDigitsInCategoryDiffFrom3 == 1)
            category = "0" + category;

        long vendorCount = vendorRepository.count() + 1;

        String vendorId = ""+year+homeProvinceId+category+vendorCount;
        return Long.valueOf(vendorId);
    }
}
