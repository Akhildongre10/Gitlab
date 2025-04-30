package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.CategoryDto;
import com.armory.WeaponVault.entityDTO.CategoryDtoInsert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T13:52:58.142954239+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
@Controller
@RequestMapping("${openapi.armoryInventoryManagementAPIs.base-path:}")
public class CategoryApiController implements CategoryApi {

    private final CategoryApiDelegate delegate;

    public CategoryApiController(@Autowired(required = false) CategoryApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CategoryApiDelegate() {});
    }

    @Override
    public CategoryApiDelegate getDelegate() {
        return delegate;
    }

}
