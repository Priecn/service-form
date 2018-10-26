package com.ido.config;

import com.ido.entity.*;
import com.ido.model.CompanyCommand;
import com.ido.model.HomeAddressCommand;
import com.ido.model.OfficeAddressCommand;
import com.ido.model.VendorWithCompanyDetailsCommand;
import com.ido.repository.*;
import com.ido.service.VendorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//@Component
public class VendorLoader implements CommandLineRunner {

    /*private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private VendorRepository vendorRepository;
    private CompanyRepository companyRepository;
    private ProvinceRepository provinceRepository;

    public VendorLoader(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, VendorRepository vendorRepository, CompanyRepository companyRepository, ProvinceRepository provinceRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.vendorRepository = vendorRepository;
        this.companyRepository = companyRepository;
        this.provinceRepository = provinceRepository;
    }*/

    private VendorService vendorService;

    public VendorLoader(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @Override
    public void run(String... args) throws Exception {

        /*HomeAddress homeAddress = new HomeAddress();
        homeAddress.setAddressLine1("HomeAddressLine1");
        homeAddress.setAddressLine2("HomeAddressLine2");
        homeAddress.setCity("Bangalore");
        homeAddress.setPincode(560100);
        homeAddress.setState("Karnataka");
        Province homeProvince = provinceRepository.getOne(4001);
        homeAddress.setProvince(homeProvince);

        OfficeAddress officeAddress = new OfficeAddress();
        officeAddress.setAddressLine1("OfficeAddressLine1");
        officeAddress.setAddressLine2("OfficeAddressLine2");
        officeAddress.setCity("Bangalore");
        officeAddress.setPincode(560101);
        officeAddress.setState("Karnataka");
        Province officeProvince = provinceRepository.getOne(4002);
        officeAddress.setProvince(officeProvince);

        Company company = new Company();
        company.setBusinessCategory(categoryRepository.getOne(0));

        Set<Integer> subCategoryIds = new HashSet<>();
        subCategoryIds.add(101);
        subCategoryIds.add(102);

        Set<BusinessSubCategory> subCategories = subCategoryIds.stream()
                .map(
                        id -> subCategoryRepository.getOne(id)
                ).collect(Collectors.toSet());
        company.setSubCategories(subCategories);
        company.setAddress(officeAddress);

        Vendor vendor = new Vendor();
        vendor.setFirstName("John");
        vendor.setLastName("Doe");
        vendor.setId(20180014001216L);
        vendor.setVendorRegDate(new Date());
        vendor.setGender(Gender.MALE);
        vendor.setPhoneNumber(1234567890L);
        vendor.setMobileNumber(1247589635L);
        vendor.setEmail("john@gmail.com");
        vendor.setDateOfBirth(new Date());
        vendor.setAddress(homeAddress);

        homeAddress.setVendor(vendor);
        officeAddress.setCompany(company);

        company.setVendor(vendor);
        vendor.setCompany(company);

        Vendor savedVendor = vendorRepository.save(vendor);
        System.out.println(savedVendor.getCompany().getAddress().getProvince());*/

        HomeAddressCommand homeAddressCommand = new HomeAddressCommand();
        homeAddressCommand.setAddressLine1("HomeAddressLine1");
        homeAddressCommand.setAddressLine2("HomeAddressLine2");
        homeAddressCommand.setCity("Bangalore");
        homeAddressCommand.setPincode(560100);
        homeAddressCommand.setState("Karnataka");
        homeAddressCommand.setProvinceId(4004);

        OfficeAddressCommand officeAddressCommand = new OfficeAddressCommand();
        officeAddressCommand.setAddressLine1("officeAddressLine1");
        officeAddressCommand.setAddressLine2("officeAddressLine2");
        officeAddressCommand.setCity("Bangalore");
        officeAddressCommand.setPincode(560100);
        officeAddressCommand.setState("Karnataka");
        officeAddressCommand.setProvinceId(4005);

        CompanyCommand companyCommand = new CompanyCommand();
        companyCommand.setAddress(officeAddressCommand);
        companyCommand.setBusinessCategoryId(1);

        Set<Integer> subCategoryIds = new HashSet<>();
        subCategoryIds.add(108);
        subCategoryIds.add(110);

        companyCommand.setSubCategoryIds(subCategoryIds);

        VendorWithCompanyDetailsCommand inputObj = new VendorWithCompanyDetailsCommand();
        inputObj.setFirstName("John");
        inputObj.setLastName("Smith");
        inputObj.setVendorRegDate(LocalDate.now());
        inputObj.setGender("MALE");
        inputObj.setPhoneNumber(1234567890L);
        inputObj.setMobileNumber(1247589635L);
        inputObj.setEmail("john@gmail.com");
        inputObj.setDateOfBirth(LocalDate.now());
        inputObj.setAddress(homeAddressCommand);
        inputObj.setCompany(companyCommand);

        Vendor vendor =vendorService.saveVendor(inputObj);
        System.out.println(vendor.getId());
    }
}
