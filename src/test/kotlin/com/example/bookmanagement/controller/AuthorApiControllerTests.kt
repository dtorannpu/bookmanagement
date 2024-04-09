package com.example.bookmanagement.controller

import com.example.bookmanagement.api.model.CreateAuthorRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.LocalDate
import javax.sql.DataSource

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class AuthorApiControllerTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    private lateinit var dataSource: DataSource

    companion object {
        val db = PostgreSQLContainer("postgres:latest")

        @BeforeAll
        @JvmStatic
        fun startDBContainer() {
            db.start()
        }

        @AfterAll
        @JvmStatic
        fun stopDBContainer() {
            db.stop()
        }

        @DynamicPropertySource
        @JvmStatic
        fun registerDBContainer(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", db::getJdbcUrl)
            registry.add("spring.datasource.username", db::getUsername)
            registry.add("spring.datasource.password", db::getPassword)
        }
    }

    @Test
    fun testCreateAuthorSuccess() {
        val request = CreateAuthorRequest("test", LocalDate.of(2000, 1, 1))
        val json = mapper.writeValueAsString(request)

        mockMvc.perform(
            post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json),
        )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("id")))
    }

    @Test
    fun testUpdateAuthor() {
    }
}
