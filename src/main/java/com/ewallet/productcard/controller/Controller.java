package com.ewallet.productcard.controller;

import com.ewallet.objects.base.EWalletRequest;
import com.ewallet.objects.base.EWalletResponse;
import com.ewallet.service.RouteServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ewallet.objects.Constants.Request.APPLICATION_JSON;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class Controller {
    private final RouteServices routeServices;

    @PostMapping(value = "/", produces = APPLICATION_JSON)
    public EWalletResponse accountFunction(@RequestBody EWalletRequest request,
                                           HttpSession session,
                                           HttpServletRequest httpRequest
    ) {
        return routeServices.routeFunction(request, session, APPLICATION_JSON, httpRequest);
    }
}
