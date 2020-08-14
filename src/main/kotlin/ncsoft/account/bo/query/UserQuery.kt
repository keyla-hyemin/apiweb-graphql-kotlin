package ncsoft.account.bo.component

import com.expediagroup.graphql.spring.operations.Query
import ncsoft.account.bo.*
import ncsoft.account.bo.config.MapperConfig
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
open class UserQuery(private val userService: UserService) : Query {

//    val mapper = ObjectMapper().registerModule(KotlinModule())

    fun AccountQuery(userId: String): Mono<Account> {
        return userService.user(userId).flatMap { user ->
            log.info(user.loginName)

            val account: Account = MapperConfig.convert(user)
            Mono.just(account)

//            Mono.just(mapper.convertValue(user, Account::class.java))

        }
//        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve().bodyToMono(Account::class.java);
    }

    fun ProfileQuery(userId: String): Mono<Profile> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", userId)).get().retrieve()
                .bodyToMono(Profile::class.java)
    }

    fun CustomerQuery(customerKey: String): Mono<Customer> {
        return WebClient.create(String.format("https://run.mocky.io/v3/%s", customerKey)).get().retrieve()
                .bodyToMono(Customer::class.java)
    }

    fun GameAccountQuery(userId: String): Mono<List<Game>> {
        return userService.gameAccount(userId).flatMap { gameAccountList ->
            val list = listOf<Game>()
            gameAccountList.forEach { g ->
                log.info(g.gameAccountId)

                val gameAccount: Game = MapperConfig.convert(g)
                list.plus(gameAccount)
            }
            Mono.just(list)
        }
    }

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(UserQuery::class.java)
    }
}


//    fun User.toAccount() = Account(
//            userId = userId,
//            userMarketCode = userMarketCode
//    )

//    object Mapper {
//        val mapper = MapperDto()
//        inline fun <S, reified T> convert(source: S): T = mapper.map(source, T::class.java)
//    }
//}