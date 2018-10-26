package com.ido.service;

import com.ido.entity.*;
import com.ido.model.VendorWithCompanyDetailsCommand;
import com.ido.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendorService {

    private VendorRepository vendorRepository;
    private ConversionUtility conversionUtility;

    @Autowired
    public VendorService(VendorRepository vendorRepository, ConversionUtility conversionUtility) {
        this.vendorRepository = vendorRepository;
        this.conversionUtility = conversionUtility;
    }


    public Vendor saveVendor(VendorWithCompanyDetailsCommand inputCommand) {
        Vendor vendor = conversionUtility.ConvertVendorWithCompanyDetailsCommandToVendor(inputCommand);
        return vendorRepository.save(vendor);
    }

    public Vendor getVendor(Long vendorId) {
        return vendorRepository.getOne(vendorId);
    }

}
