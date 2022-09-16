package com.example.sql;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService cateService;
    @Autowired
    private CoverService coverService;

    @GetMapping("/getdata")
    public String getBlog(Model model, @RequestParam("id") Optional<Integer> id){
        List<Blog> listBlog = new ArrayList<>();
        if(id.isPresent()) {
            listBlog = blogService.listAllFilter(id.get());
        } else {
            listBlog = blogService.listAll();
        }

        List<Category> listCate = cateService.listAllCategory();

        model.addAttribute("listBlog",listBlog);
        model.addAttribute("blog",new BlogForm());
        model.addAttribute("listCate",listCate);
        model.addAttribute("category",new Category());

        return "list";
    }
    @GetMapping("/create")
    public String getCreateForm(Model model){
        model.addAttribute("blog",new Blog());

        return "create_form";
    }
    @GetMapping("/test")
    public String getTest(Model model){
//        model.addAttribute("blog",new Blog());

        return "template";
    }

    @Autowired
    Environment env;

    @PostMapping("/save") public String uploadImage(@ModelAttribute("blog") BlogForm blogForm, BindingResult result) throws IOException {
        Category category = cateService.getCategory(blogForm.getCategory().getId());

        Blog blog = new Blog(blogForm.getTitle(), blogForm.getContent(), category);
        int blog_id = 0;

        if (blogForm.getId() == 0)
            blog_id = blogService.saveAndReturn(blog).getId();
        else {
            blogService.update(blogForm.getId(), blog);
            blog_id = blogForm.getId();
        }

        for(MultipartFile file: blogForm.getFile()) {
            String fileName = file.getOriginalFilename();
            String fileUpload = env.getProperty("upload.path");
            try {
                FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
                Cover cover = new Cover(fileName,blogService.get(blog_id));
                Blog blogg = blogService.get(blog_id);
                System.out.println(blogg.getId());
//                if(blogForm.getId() != 0) {
//                    for (Cover c : blogg.getFile()) {
//                        coverService.deleteBy(c.getId());
//                    }
//                }

                coverService.save(cover);

            } catch (IOException e) {
                e.printStackTrace();

                throw new RuntimeException(e);

            }
        }

        return "redirect:/getdata?id="+blogForm.getCategory().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        Blog blog = blogService.get(id);

            for (Cover c : blog.getFile()) {
                coverService.deleteBy(c.getId());
            }

        blogService.delete(id);
        return "redirect:/getdata";
    }




}
