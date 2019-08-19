package cd.zzh.community.controller;

import cd.zzh.community.Mapper.QuestionMapper;
import cd.zzh.community.dto.QuestionDTO;
import cd.zzh.community.service.QuestionServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionServive questionServive;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionServive.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
