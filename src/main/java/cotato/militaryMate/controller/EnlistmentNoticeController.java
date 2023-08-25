package cotato.militaryMate.controller;

import cotato.militaryMate.domain.dto.ApiResponse;
import cotato.militaryMate.domain.dto.enlistmentNotice.EnlistmentNoticeListResponse;
import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeRequest;
import cotato.militaryMate.domain.dto.enlistmentNotice.SendEnlistmentNoticeResponse;
import cotato.militaryMate.service.EnlistmentNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enlistment_notice")
public class EnlistmentNoticeController {
    private final EnlistmentNoticeService enlistmentNoticeService;

    @PostMapping("")
    public ApiResponse<SendEnlistmentNoticeResponse> sendEnlistmentNotice(@RequestBody SendEnlistmentNoticeRequest sendEnlistmentNoticeRequest) {
        return ApiResponse.createSuccess(enlistmentNoticeService.sendEnlistmentNotice(sendEnlistmentNoticeRequest));
    }

    @GetMapping("/received/{receiverId}")
    public ApiResponse<EnlistmentNoticeListResponse> getReceivedEnlistmentNoticeList(@PathVariable("receiverId") Long receiverId) {
        return ApiResponse.createSuccess(enlistmentNoticeService.getReceivedEnlistmentNoticeList(receiverId));
    }

    @GetMapping("/send/{senderId}")
    public ApiResponse<EnlistmentNoticeListResponse> getSendEnlistmentNoticeList(@PathVariable("senderId") Long senderId) {
        return ApiResponse.createSuccess(enlistmentNoticeService.getSendEnlistmentNoticeList(senderId));
    }
}
