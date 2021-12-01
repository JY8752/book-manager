package com.book.manager.presentation.controller

import com.book.manager.application.service.AdminBookService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin/book")
@CrossOrigin(value = ["localhost:8080"], allowCredentials = "true")
class AdminBookController(
    private val adminBookService: AdminBookService
) {

}