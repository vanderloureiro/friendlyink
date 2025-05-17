package dev.vanderloureiro
package config

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import zio.*

import javax.sql.DataSource

object DatabaseConfig {
  val live: ULayer[DataSource] = ZLayer.succeed {
    val config = new HikariConfig()
    config.setJdbcUrl("jdbc:postgresql://localhost:5432/friendlyink")
    config.setUsername("postgres")
    config.setPassword("root")
    config.setDriverClassName("org.postgresql.Driver")
    config.setMaximumPoolSize(10)
    new HikariDataSource(config)
  }
}
