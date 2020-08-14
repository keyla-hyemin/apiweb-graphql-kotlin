package ncsoft.account.bo.service

import com.ncsoft.aframework.npclient.api.NPClientOperationsLookup
import com.ncsoft.aframework.npclient.operations.beans.account.GameAccountGameCode
import com.ncsoft.aframework.npclient.operations.gameaccount.reactive.GameAccountReactiveOperations
import com.ncsoft.aframework.npclient.operations.profile.UserProfile
import com.ncsoft.aframework.npclient.operations.profile.reactive.ProfileReactiveOperations
import com.ncsoft.aframework.npclient.operations.users.User
import com.ncsoft.aframework.npclient.operations.users.UserParam
import com.ncsoft.aframework.npclient.operations.users.reactive.UsersReactiveOperations
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(private val npClientOperationsLookup: NPClientOperationsLookup) {

//    @Autowired
//    lateinit var npClientOperationsLookup: NPClientOperationsLookup

    fun user(userId: String): Mono<User> {
        val operations = npClientOperationsLookup.findOperations("plaync-appgate", UsersReactiveOperations::class.java)
        val param = UserParam.withUserId(userId).build();
        return operations.user(param);
    }

    fun gameAccount(userId: String): Mono<List<GameAccountGameCode>> {
        val operations = npClientOperationsLookup.findOperations("plaync-appgate", GameAccountReactiveOperations::class.java)
        return operations.games(userId);
    }

    fun userProfile(userId: String): Mono<UserProfile> {
        val operations = npClientOperationsLookup.findOperations("plaync-appgate", ProfileReactiveOperations::class.java)
        return operations.userProfile(userId);
    }
}