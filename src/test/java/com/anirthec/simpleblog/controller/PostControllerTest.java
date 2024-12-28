package com.anirthec.simpleblog.controller;

import com.anirthec.simpleblog.model.Post;
import com.anirthec.simpleblog.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class PostControllerTest {

    @Mock
    private PostService postService;

    @Mock
    private Model model;

    @InjectMocks
    private PostController postController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void testIndex() throws Exception {
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("Title 1");
        post1.setContent("Content 1");

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("Title 2");
        post2.setContent("Content 2");

        when(postService.getAllPosts()).thenReturn(Arrays.asList(post1, post2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(postService, times(1)).getAllPosts();
        verify(model, times(1)).addAttribute(eq("posts"), anyList());
    }

    @Test
    void testViewPost() throws Exception {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Title 1");
        post.setContent("Content 1");

        when(postService.getPostById(1L)).thenReturn(post);

        mockMvc.perform(get("/post/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post"));

        verify(postService, times(1)).getPostById(1L);
        verify(model, times(1)).addAttribute(eq("post"), any(Post.class));
    }

    @Test
    void testNewPostForm() throws Exception {
        mockMvc.perform(get("/post/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("postForm"));

        verify(model, times(1)).addAttribute(eq("post"), any(Post.class));
    }

    @Test
    void testDeletePost() throws Exception {
        mockMvc.perform(get("/post/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(postService, times(1)).deletePost(1L);
    }
}