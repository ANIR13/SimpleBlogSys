package com.anirthec.simpleblog.service;

import com.anirthec.simpleblog.model.Post;
import com.anirthec.simpleblog.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPosts() {
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("Title 1");
        post1.setContent("Content 1");

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("Title 2");
        post2.setContent("Content 2");

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2));

        List<Post> posts = postService.getAllPosts();
        assertEquals(2, posts.size());
        verify(postRepository, times(1)).findAll();
    }

    @Test
    void testGetPostById() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Title 1");
        post.setContent("Content 1");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Post foundPost = postService.getPostById(1L);
        assertNotNull(foundPost);
        assertEquals("Title 1", foundPost.getTitle());
        verify(postRepository, times(1)).findById(1L);
    }

    @Test
    void testSavePost() {
        Post post = new Post();
        post.setTitle("Title 1");
        post.setContent("Content 1");

        when(postRepository.save(post)).thenReturn(post);

        Post savedPost = postService.savePost(post);
        assertNotNull(savedPost);
        assertEquals("Title 1", savedPost.getTitle());
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void testDeletePost() {
        postService.deletePost(1L);
        verify(postRepository, times(1)).deleteById(1L);
    }
}