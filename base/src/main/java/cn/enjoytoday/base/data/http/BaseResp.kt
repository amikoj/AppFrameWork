package cn.enjoytoday.base.data.http

/**
 * 能用响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
data class BaseResp<out T>(val code: Int,
                           val msg: String,
                           val data: T?=null)