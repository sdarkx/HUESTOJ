// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 13:57
// @Author : x_DARK_
// @File : CodePool.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.service.Impl.utils;

import org.springframework.util.MultiValueMap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CodePool extends Thread {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<CodeA> codes = new LinkedList<>();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (codes.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            } else {
                CodeA code = codes.remove();
                lock.unlock();
                consume(code);  // 比较耗时，可能会执行几秒钟
            }
        }

    }

    private void consume(CodeA code) {
        Consumer consumer = new Consumer();
        consumer.startTimeOut(2000, code);
    }

    public void addCode(MultiValueMap<String, String> data) {
        lock.lock();
        try {
            codes.add(new CodeA(data.getFirst("id"), data.getFirst("code")));
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
