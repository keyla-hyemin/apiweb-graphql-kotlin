package ncsoft.account.bo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import graphql.schema.DataFetchingEnvironment
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@GraphQLDescription("User")
@KeyDirective(fields = FieldSet("userId"))
@ExtendsDirective
data class Account(@ExternalDirective val userId: String="", val games: List<Game>? = null, val userStatus: Int? = null, val userMarketCode: Int=0, val userProfile: Int=0) {

    fun listAccount(dataFetchingEnvironment: DataFetchingEnvironment) : Mono<List<Account>>{
        val userContacts = dataFetchingEnvironment.executionStepInfo.parent.parent.arguments["userContacts"]
//                var accounts = Flux.empty<Account>()
//        for (userContact in userContacts) {
//            accounts = accounts.concatWith(UserQuery().AccountQuery(userContact.userId))
//        }
//
//        return accounts.collectList();

        return Mono.just(listOf())
    }

    fun profiles(): Mono<Profile> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
                .bodyToMono(Profile::class.java)
    }
    fun gameAccounts(): Mono<GameAccount> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
                .bodyToMono(GameAccount::class.java)
    }
}

