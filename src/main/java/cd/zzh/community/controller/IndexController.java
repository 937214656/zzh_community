package cd.zzh.community.controller;

import cd.zzh.community.Mapper.QuestionMapper;
import cd.zzh.community.Mapper.UserMapper;
import cd.zzh.community.dto.PaginationDTO;
import cd.zzh.community.dto.QuestionDTO;
import cd.zzh.community.model.Question;
import cd.zzh.community.model.User;
import cd.zzh.community.service.QuestionServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionServive questionServive;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0)
        for(Cookie cookie : cookies){
            if("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        PaginationDTO pagination = questionServive.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
