package ru.mephi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexLibTest {

    @Test
    public void kpath() {
        String str1 = "abc";
        String str2 = "a|b";
        String str3 = "ab|c";
        String str4 = "a+";
        String str5 = "ab+";
        String str6 = "ab|c+";
        String str7 = "ab{1,3}"; // a(^|b|(bb)|(bbb))
        String str8 = "a|b{3}"; // a|((bb)(b|b+))
        String str9 = "(abc){1,2}";
        String str10 = "(ab+){2,3}";
        RegexLib rl = new RegexLib();
        String out1 = rl.kpath(rl.compile(str1));
        Assert.assertEquals(out1, "((a((^)+|^)(b))((^)+|^)(c|(c((^)+|^)(^))))|(((^)+|^)(((a((^)+|^)(b))((^)+|^)(c|(c((^)+|^)(^))))))");
        String out2 = rl.kpath(rl.compile(str2));
        Assert.assertEquals(out2, "b|a|(b|a((^)+|^)(^))|(((^)+|^)(b|a|(b|a((^)+|^)(^))))");
        String out3 = rl.kpath(rl.compile(str3));
        Assert.assertEquals(out3, "(a((^)+|^)(c|b))|((a((^)+|^)(c|b))((^)+|^)(^))|(((^)+|^)((a((^)+|^)(c|b))|((a((^)+|^)(c|b))((^)+|^)(^))))");
        String out4 = rl.kpath(rl.compile(str4));
        Assert.assertEquals(out4, "a|(((^)+|^)(a))|(a|(((^)+|^)(a))((a|^)+|^)(a|^))");
        String out5 = rl.kpath(rl.compile(str5));
        Assert.assertEquals(out5, "(a|(((^)+|^)(a))((^)+|^)(b))|((a|(((^)+|^)(a))((^)+|^)(b))((b|^)+|^)(b|^))");
        String out6 = rl.kpath(rl.compile(str6));
        Assert.assertEquals(out6, "(a((^)+|^)(c|b))|((a((^)+|^)(c|b))((c|^)+|^)(c|^))|(((^)+|^)((a((^)+|^)(c|b))|((a((^)+|^)(c|b))((c|^)+|^)(c|^))))");
        String out7 = rl.kpath(rl.compile(str7));
        Assert.assertEquals(out7, "(a|(((^)+|^)(a))((^)+|^)(b))|((a|(((^)+|^)(a))((^)+|^)(b))((b|^)+|^)(b|^))");
    }

    @Test
    public void search() {
    }

    @Test
    public void complement() {
    }

    @Test
    public void intersection() {
    }
}