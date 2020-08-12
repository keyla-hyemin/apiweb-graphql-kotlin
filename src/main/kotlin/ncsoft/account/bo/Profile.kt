package ncsoft.account.bo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@GraphQLDescription("User Profile")
@KeyDirective(fields = FieldSet("userId"))
@ExtendsDirective
data class Profile(@ExternalDirective val userId: String, val name: String, val age: Int, val email: String) {
}

//data class Review(val reviewId: String, val text: String)