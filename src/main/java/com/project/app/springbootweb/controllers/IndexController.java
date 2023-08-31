package com.project.app.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.app.springbootweb.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {
  @GetMapping(value = { "", "/", "/home" })
  public String index(Model model) {
    model.addAttribute("title", "Title for Spring");
    return "index";
  }

  @GetMapping("/profile")
  public String profile(Model model) {
    User user = new User();
    user.setFirstName("Bruce");
    user.setLastName("Wayne");
    model.addAttribute("title", "Profile");
    model.addAttribute("user", user);
    return "profile";
  }

  @GetMapping("/users")
  public String users(Model model) {
    model.addAttribute("title", "User list");
    return "users";
  }

  @GetMapping("/query-params")
  public String queryParams(
      @RequestParam(defaultValue = "default", required = false) String text,
      @RequestParam(defaultValue = "7", required = false) Integer myNumber,
      Model model) {
    model.addAttribute("title", "Query Params");
    model.addAttribute("text", text);
    model.addAttribute("myNumber", myNumber);
    return "query-params";
  }

  @GetMapping("/path-params/{myParam1}/{myParam2}")
  public String pathParams(
      @PathVariable String myParam1,
      @PathVariable String myParam2,
      Model model) {
    model.addAttribute("title", "Path Params");
    model.addAttribute("myParam1", myParam1);
    model.addAttribute("myParam2", myParam2);
    return "path-params";
  }

  @GetMapping("/redirect")
  public String localRedirect() {
    return "redirect:/app/home";
  }

  @GetMapping("/forward")
  public String localForward() {
    return "forward:/app/home";
  }

  @ModelAttribute("users")
  public List<User> fillUsers() {
    List<User> users = new ArrayList<>();
    users.add(new User("Bruce", "Wayne", "batman@test.com"));
    users.add(new User("Clark", "Kent", "superman@test.com"));
    users.add(new User("Diana", "Prince", "wonderwoman@test.com"));
    return users;
  }
}
