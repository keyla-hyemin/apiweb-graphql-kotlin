package ncsoft.account.bo

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
open class UserQuery() : Query {

    fun AccountQuery(userId: String): Mono<Account> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
                .bodyToMono(Account::class.java);
    }

    fun ProfileQuery(userId: String): Mono<Profile> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
                .bodyToMono(Profile::class.java)
    }

    fun CustomerQuery(customerKey: String): Mono<Customer> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", customerKey)).get().retrieve()
                .bodyToMono(Customer::class.java)
    }

    fun GameAccountQuery(GameAccountId: String): Mono<GameAccount> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", GameAccountId)).get().retrieve()
                .bodyToMono(GameAccount::class.java)
    }
}