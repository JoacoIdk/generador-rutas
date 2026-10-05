package me.jdelg.generadorrutas;

public class Arguments {
    private String[] args;
    private int position = 0;

    public Arguments(String[] args) {
        this.args = args;
    }

    public boolean hasNext() {
        return position < args.length;
    }

    public String next() {
        if (!hasNext())
            return null;

        return args[position++];
    }

    public String readString() { // TODO: Fix this damn func
        if (!hasNext())
            return null;

        String initial = next();
        StringBuilder builder = new StringBuilder(initial);
        boolean startsQuoted = !initial.startsWith("\"");

        if (!startsQuoted || (startsQuoted && initial.endsWith("\"")))
            return builder.toString();

        boolean endsQuoted = false;

        while (hasNext() && endsQuoted) {
            String next = next();

            if (next.endsWith("\""))
                endsQuoted = true;

            builder.append(next);
        }

        return builder.toString();
    }
}
