package ncsoft.account.bo

import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import ncsoft.account.bo.schema.Account
import ncsoft.account.bo.schema.Game
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("GameAccountDataFetcher")
@Scope("prototype")
class GameAccountDataFetcher : DataFetcher<Game>, BeanFactoryAware {

    private lateinit var beanFactory: BeanFactory

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }

    @Throws(Exception::class)
    override fun get(environment: DataFetchingEnvironment?): Game {
        val userId = environment?.getSource<Account>()?.userId
        if (userId == null) {
            throw Exception("Cannot retrieve games, userId is null")
        } else {
            return beanFactory.getBean(userId) as Game
        }
    }
}
