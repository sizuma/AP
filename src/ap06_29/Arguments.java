package ap06_29;

import java.util.Arrays;

public class Arguments {
    public final boolean help;
    public final boolean interactive;
    public final boolean recursive;
    public final boolean update;
    public final boolean verbose;
    public final String[] args;

    public Arguments(String[] args){
        help = Arrays.stream(args).anyMatch(s -> s.equals("-h"));
        interactive = Arrays.stream(args).anyMatch(s -> s.equals("-i"));
        recursive = Arrays.stream(args).anyMatch(s -> s.equals("-r"));
        update = Arrays.stream(args).anyMatch(s -> s.equals("-u"));
        verbose = Arrays.stream(args).anyMatch(s -> s.equals("-v"));
        this.args = Arrays.stream(args).filter(s -> !s.startsWith("-")).toArray(String[]::new);
    }


}
