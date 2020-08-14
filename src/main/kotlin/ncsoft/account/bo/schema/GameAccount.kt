package ncsoft.account.bo.schema

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.annotations.GraphQLDirective
import com.expediagroup.graphql.annotations.GraphQLIgnore
import ncsoft.account.bo.config.MapperConfig
import ncsoft.account.bo.query.UserQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@GraphQLDescription("User's Game")
@Component
@Scope("prototype")
data class Game @Autowired(required = false) constructor(val userId: String, @GraphQLIgnore val userQuery: UserQuery) {

    fun getGameAccounts(): Mono<List<Game>> = MapperConfig.convert(userQuery.GameAccountQuery(userId))
}

//data class Review(val reviewId: String, val text: String)