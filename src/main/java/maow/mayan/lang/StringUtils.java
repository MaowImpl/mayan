package maow.mayan.lang;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    private static final Pattern ARGS = Pattern.compile("([^\"]\\S*|\".+?\")\\s*");

    public static String fromBytes(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static String collapseList(List<String> list) {
        return String.join("", list);
    }

    public static List<String> separateArgs(String string) {
        final List<String> args = new ArrayList<>();
        final Matcher matcher = ARGS.matcher(string);
        while (matcher.find()) {
            args.add(matcher.group(1).trim().replaceAll("\"", ""));
        }
        return args;
    }
}
