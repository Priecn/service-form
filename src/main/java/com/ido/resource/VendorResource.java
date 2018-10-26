package com.ido.resource;

import com.ido.entity.Vendor;
import com.ido.model.VendorWithCompanyDetailsCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vendor")
public class VendorResource {

    @PostMapping("/save")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorWithCompanyDetailsCommand> getVendor(@PathVariable Long id) {
        return null;
    }
}
