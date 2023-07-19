package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
//    private final MemberService memberService = new MemberService();
//    위 방식은 다른 컨트롤러와 MemberService 공유가 불가능. 즉, 싱글톤 관리가 안됨.
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
