package cn.zerry.baeldung.core;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 客户端处理器
 *
 * @Author: linzengrui
 * @Date: 2020/5/7 0:14
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        RequestData msg = new RequestData();
        msg.setIntValue(123)
                .setStringValue("good good study day day up");
        ChannelFuture channelFuture = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((ResponseData)msg);
        ctx.close();
    }
}
