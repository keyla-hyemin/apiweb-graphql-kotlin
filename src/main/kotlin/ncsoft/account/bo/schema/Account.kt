package ncsoft.account.bo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.annotations.GraphQLIgnore
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import ncsoft.account.bo.component.UserQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@GraphQLDescription("User")
@KeyDirective(fields = FieldSet("userId"))
@ExtendsDirective
@Component
@Scope("prototype")
data class Account (@ExternalDirective val userId: String = "", val userMarketCode: String = "") {
//    , private val userQuery: UserQuery
//    fun listAccount(dataFetchingEnvironment: DataFetchingEnvironment) : Mono<List<Account>>{
//        val userContacts = dataFetchingEnvironment.executionStepInfo.parent.parent.arguments["userContacts"]
////                var accounts = Flux.empty<Account>()
////        for (userContact in userContacts) {
////            accounts = accounts.concatWith(UserQuery().AccountQuery(userContact.userId))
////        }
////
////        return accounts.collectList();
//
//        return Mono.just(listOf())
//    }

//    @JsonIgnore
//    lateinit var gameAccounts: Game

    @GraphQLIgnore
    @Autowired
    lateinit var userQuery: UserQuery

    fun gameAccounts(): Mono<List<Game>> {
        return userQuery.GameAccountQuery(userId)
    }

//    fun profiles(): Mono<Profile> {
//        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
//                .bodyToMono(Profile::class.java)
//    }
}
