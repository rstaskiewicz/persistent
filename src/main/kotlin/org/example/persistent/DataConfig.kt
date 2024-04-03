package org.example.persistent

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing
import org.springframework.data.web.config.EnableSpringDataWebSupport

@Configuration
@EnableJdbcAuditing
@EnableSpringDataWebSupport
class DataConfig {
}