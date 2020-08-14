package ncsoft.account.bo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@GraphQLDescription("Customer")
@KeyDirective(fields = FieldSet("customerKey"))
@ExtendsDirective
data class Customer(@ExternalDirective val customerKey: String, val userContacts: List<UserContact>) {
//    fun accounts() = Account(userContacts.get(0).userId)2
//    fun accounts() = UserQuery().AccountQuery(userContacts.get(0).userId)

//    fun accounts() : Mono<List<Account>> {
//        var accounts = Flux.empty<Account>()
//        for (userContact in userContacts) {
//            accounts = accounts.concatWith(UserQuery().AccountQuery(userContact.userId))
//        }
//
//        return accounts.collectList();
//    }
}

//Customer{
//    accounts{
//        listAccount{
//            Account.....
//        }
//    }
//}
