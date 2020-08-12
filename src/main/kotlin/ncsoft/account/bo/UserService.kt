package ncsoft.account.bo

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class UserService() {

    protected val client: WebClient? = null

    open fun getUserInfo(): Mono<Account> {
        return WebClient.create("https://run.mocky.io/v3/543e4beb-6708-4b71-99eb-b9d1176217c1").get().retrieve()
            .bodyToMono(Account::class.java);
    }
}