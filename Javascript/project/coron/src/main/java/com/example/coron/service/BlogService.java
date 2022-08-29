package com.example.coron.service;

import com.example.coron.dto.BlogDto;
import com.example.coron.entity.Blog;
import com.example.coron.repository.BlogRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.BlogRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {


    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    // Get all blog Dto for rendering in admin/blogs
    public List<BlogDto> getAllBlogDto(){
        List<Blog> blogs= blogRepository.findAll();
        return blogs.stream()
                .map(blog -> modelMapper.map(blog, BlogDto.class))
                .sorted((a,b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .collect(Collectors.toList());
    }

    // Get all blog by user id
    public List<BlogDto> getAllBlogDtoByUserId(Integer id){
        List<Blog> blogs= blogRepository.getByUser_Id(id);
        return blogs.stream()
                .map(blog -> modelMapper.map(blog, BlogDto.class))
                .sorted((a,b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .collect(Collectors.toList());
    }

    //Get information of a blog by id
    public BlogDto getBlogById(Integer id){
        Blog blog = blogRepository.getById(id);
        return modelMapper.map(blog, BlogDto.class);
    }


    public void createBlog(BlogRequest request){
        // Todo: xử lý tags
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .description(request.getDescription())
                .status(request.getStatus())
                .user(userRepository.findById(1).get())
                .build();

        blogRepository.save(blog);
    }

    public void updateBlog(BlogRequest request, Integer id) {
        // Todo: xử lý tags
        Blog blog = Blog.builder()
                .id(id)
                .title(request.getTitle())
                .content(request.getContent())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();

        blogRepository.save(blog);
    }

    public void deleteBlogById(Integer id) {
        blogRepository.deleteById(id);
    }
}
