package com.example.Controller;


import com.example.Model.Entity.Blog;
import com.example.Model.Entity.Category;
import com.example.Model.Entity.Cover;
import com.example.Model.Form.BlogForm;
import com.example.Service.BlogService;
import com.example.Service.CategoryService;
import com.example.Service.CoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private CategoryService cateService;
    @Autowired
    Environment env;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlog(){
        return new ResponseEntity<List<Blog>>(blogService.getAllBlog(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") int id){
        Blog blog = blogService.get(id);

        for (Cover c : blog.getCovers()) {
            coverService.deleteServiceByBlogID(c.getId());
        }

        blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/cate")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<List<Category>>(cateService.getAllCategory(), HttpStatus.OK);
    }
    @PostMapping("/create") public  ResponseEntity<Blog> uploadImage(@ModelAttribute("blog") BlogForm blogForm, BindingResult result) throws IOException {
        Category category = cateService.getCategory(blogForm.getCategory().getId());

        Blog blog = new Blog(blogForm.getTitle(), blogForm.getContent(), category);
        int blog_id = blogService.addBlog(blog).getId();


        for(MultipartFile file: blogForm.getCovers()) {
            String fileName = file.getOriginalFilename();
            String fileUpload = env.getProperty("upload.path");
            try {
                FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
                Cover cover = new Cover(fileName,blogService.get(blog_id));
                Blog blogg = blogService.get(blog_id);
                System.out.println(blogg.getId());


                coverService.save(cover);

            } catch (IOException e) {
                e.printStackTrace();

                throw new RuntimeException(e);

            }
        }

        return new ResponseEntity<>(blogService.get(blog_id), HttpStatus.CREATED);
    }











}
