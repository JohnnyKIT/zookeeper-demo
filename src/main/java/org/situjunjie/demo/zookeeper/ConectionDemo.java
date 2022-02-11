package org.situjunjie.demo.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ConectionDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("47.118.67.118:2181", 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watcher响应"+watchedEvent.getPath()+" "+watchedEvent.getState()+" "+watchedEvent.getType());
            }
        });
        System.out.println("zookeeper连接状态==>"+zooKeeper.getState());
        zooKeeper.create("/runoob","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }
}
