package de.gzockoll.tools.springbootadmin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter



@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
class SpringBootAdminApplication {

    @Configuration
    class SecurityPermitAllConfig : WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        override protected fun configure(http: HttpSecurity) {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootAdminApplication>(*args)
}
