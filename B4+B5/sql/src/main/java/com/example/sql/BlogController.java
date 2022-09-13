package com.example.sql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getdata")
    public String getBlog(Model model){
        List<Blog> listBlog = blogService.listAll();
        model.addAttribute("listBlog",listBlog);
        model.addAttribute("blog",new Blog());
        System.out.println("list +" + listBlog.size());
        return "list";
    }
    @GetMapping("/create")
    public String getCreateForm(Model model){
        model.addAttribute("blog",new Blog());

        return "create_form";
    }
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/save";

    @PostMapping("/save") public String uploadImage(@ModelAttribute("blog") BlogForm blogForm, BindingResult result, @RequestParam("file_upload") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        System.out.println(fileNameAndPath);

        Blog blog = new Blog(0,blogForm.getTitle(), blogForm.getCover(),blogForm.getContent(),fileNameAndPath.toString());
        blogService.save(blog);
        return "redirect:/getdata";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try {
            Blog blog = blogService.get(id);
            model.addAttribute("blog",blog);
        }catch (Exception e){
            return "redirect:/getdata";
        }
        return "edit_form";

    }
    @PostMapping("/update")
    public String saveUser(@ModelAttribute("blog") Blog blog, BindingResult result, @RequestParam("file_upload") MultipartFile file){
        blogService.update(blog.getId(), blog);
        return "redirect:/getdata";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        blogService.delete(id);
        return "redirect:/getdata";
    }




}
