package net.jcip.thinkinjava.annotations.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by robin on 2017/7/21.
 */
public class Client {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        UseCaseTracker.trackUseCases(useCases, PasswordUtils.class);
    }
}
