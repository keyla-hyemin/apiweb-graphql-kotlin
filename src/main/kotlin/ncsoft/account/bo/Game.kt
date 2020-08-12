package ncsoft.account.bo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@GraphQLDescription("User Game")
data class Game(val gameCode: String, val gameAccountId: String) {
//    fun reviews(): List<Review> {
//        // returns list of product reviews
//        val list = listOf(Review("1", "a"), Review("2", "b"));
//        return list;
//    }
}

//data class Review(val reviewId: String, val text: String)