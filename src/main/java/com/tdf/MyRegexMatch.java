package com.tdf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyRegexMatch {


    public static void main(String[] args) {
        String reg = "\\A(A|AM|B|BA|BB|BD|BG|BH|BL|BM|BN|BP|BR|BZ|DL|DO|E|EF|EU|FB|FE|FF|FK|FR|FV|G|GB|GD|GF|GK|GM|GR|GS|GU|HA|HB|HE|HF|HL|HO|I|IL|IM|JE|JO|JU|JW|K|KB|KI|KF|KK|KL|KO|KR|KS|KU|L|LA|LB|LE|LF|LI|LL|LN|LZ|MA|MD|ME|MI|MT|MU|MZ|N|ND|NK|O|OP|OW|P|PE|PL|PT|RA|RE|RI|RO|S|SB|SD|SE|SK|SL|SP|SO|SR|ST|SV|SW|SZ|T|TA|TD|TK|TU|UU|V|VB|VD|VI|VK|VL|VO|W|WB|WD|WK|WE|WL|WN|WO|WT|WU|WY|WZ|ZE|ZT|ZW){1,2} \\d{4} [A-Z]{1,2}\\z";

        //String reg = "\\A(A|AM|B|BA|BB|BD|BG|BH|BL|BM|BN|BP|BR|BZ|DL|DO|E|EF|EU|FB|FE|FF|FK|FR|FV|G|GB|GD|GF|GK|GM|GR|GS|GU|HA|HB|HE|HF|HL|HO|I|IL|IM|JE|JO|JU|JW|K|KB|KI|KF|KK|KL|KO|KR|KS|KU|L|LA|LB|LE|LF|LI|LL|LN|LZ|MA|MD|ME|MI|MT|MU|MZ|N|ND|NK|O|OP|OW|P|PE|PL|PT|RA|RE|RI|RO|S|SB|SD|SE|SK|SL|SP|SO|SR|ST|SV|SW|SZ|T|TA|TD|TK|TU|UU|V|VB|VD|VI|VK|VL|VO|W|WB|WD|WK|WE|WL|WN|WO|WT|WU|WY|WZ|ZE|ZT|ZW) (?=[^0])\\d+ (?=[^O])[[:alpha:]]+\\z|\\A[[:alpha:]]{2} (?=[^0])\\d{5}\\z|\\AWD-(?=[^0])[0-9]\\d{2,20}\\z|\\A(?=[[:alpha:] \\d]{6,9}\\z)";

        Pattern pat = Pattern.compile(reg, Pattern.MULTILINE);
        System.out.println(pat.matcher("X 1330 Q").matches());

        /*
        * (A|AM|B|BA|BB|BD|BG|BH|BL|BM|BN|BP|BR|BZ|DL|DO|E|EF|EU|FB|FE|FF|FK|FR|FV|G|GB|GD|GF|GK|GM|GR|GS|GU|HA|HB|HE|HF|HL|HO|I|IL|IM|JE|JO|JU|JW|K|KB|KI|KF|KK|KL|KO|KR|KS|KU|L|LA|LB|LE|LF|LI|LL|LN|LZ|MA|MD|ME|MI|MT|MU|MZ|N|ND|NK|O|OP|OW|P|PE|PL|PT|RA|RE|RI|RO|S|SB|SD|SE|SK|SL|SP|SO|SR|ST|SV|SW|SZ|T|TA|TD|TK|TU|UU|V|VB|VD|VI|VK|VL|VO|W|WB|WD|WK|WE|WL|WN|WO|WT|WU|WY|WZ|ZE|ZT|ZW)*/
        final String regex = "\\A(?=[[:alpha:] \\d]{4}\\z)(A|AM|B|BA|BB|BD|BG|BH|BL|BM|BN|BP|BR|BZ|DL|DO|E|EF|EU|FB|FE|FF|FK|FR|FV|G|GB|GD|GF|GK|GM|GR|GS|GU|HA|HB|HE|HF|HL|HO|I|IL|IM|JE|JO|JU|JW|K|KB|KI|KF|KK|KL|KO|KR|KS|KU|L|LA|LB|LE|LF|LI|LL|LN|LZ|MA|MD|ME|MI|MT|MU|MZ|N|ND|NK|O|OP|OW|P|PE|PL|PT|RA|RE|RI|RO|S|SB|SD|SE|SK|SL|SP|SO|SR|ST|SV|SW|SZ|T|TA|TD|TK|TU|UU|V|VB|VD|VI|VK|VL|VO|W|WB|WD|WK|WE|WL|WN|WO|WT|WU|WY|WZ|ZE|ZT|ZW) (?=[^0])\\d+ (?=[^O])[[:alpha:]]+\\z|\\A[[:alpha:]]{2} (?=[^0])\\d{5}\\z|\\AWD-(?=[^0])[0-9]\\d{2,20}\\z|\\A(?=[[:alpha:] \\d]{6,9}\\z)(A|AM|B|BA|BB|BD|BG|BH|BL|BM|BN|BP|BR|BZ|DL|DO|E|EF|EU|FB|FE|FF|FK|FR|FV|G|GB|GD|GF|GK|GM|GR|GS|GU|HA|HB|HE|HF|HL|HO|I|IL|IM|JE|JO|JU|JW|K|KB|KI|KF|KK|KL|KO|KR|KS|KU|L|LA|LB|LE|LF|LI|LL|LN|LZ|MA|MD|ME|MI|MT|MU|MZ|N|ND|NK|O|OP|OW|P|PE|PL|PT|RA|RE|RI|RO|S|SB|SD|SE|SK|SL|SP|SO|SR|ST|SV|SW|SZ|T|TA|TD|TK|TU|UU|V|VB|VD|VI|VK|VL|VO|W|WB|WD|WK|WE|WL|WN|WO|WT|WU|WY|WZ|ZE|ZT|ZW) [A-PR-Z]+ (?=[^0])\\d+\\z";
        final String string = "WT 1330 H";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.matches());
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
