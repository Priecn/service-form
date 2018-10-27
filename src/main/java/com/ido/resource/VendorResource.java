package com.ido.resource;

import com.ido.entity.Vendor;
import com.ido.model.VendorWithCompanyDetailsCommand;
import com.ido.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vendor")
public class VendorResource {

    private VendorService vendorService;

    public VendorResource(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Vendor> addVendor(@RequestBody VendorWithCompanyDetailsCommand vendorCommand) {
        Vendor vendor = vendorService.saveVendor(vendorCommand);
        if(vendor != null)
            return ResponseEntity.ok(vendor);
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendor(id);

        if(vendor != null)
            return ResponseEntity.ok(vendor);
        return ResponseEntity.badRequest().body(null);
    }
}
