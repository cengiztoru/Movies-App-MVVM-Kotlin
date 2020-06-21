package com.cengiztoru.movies_simplifiedcoding.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**     Code With 💗
 * Created by Cengiz TORU
 * cengiztoru@gmail.com
 */

object Coroutines {

    /**
     * @author Cengiz TORU
     * Function has two parameters
     * @param work is a suspend function. Dont take any parameters. Return one nullable data as T
     * @param callback return result of after executing the (@param work) suspending function
     *                  take one parameter, no return anything it is unit.
     * */
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }


}