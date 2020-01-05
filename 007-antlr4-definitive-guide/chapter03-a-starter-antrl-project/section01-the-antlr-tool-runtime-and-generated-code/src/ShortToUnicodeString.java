public class ShortToUnicodeString extends ArrayInitBaseListener {
    // 将类似{l,2,3}的short数组初始化语句翻译为"\u0001\u0002\u0003"

    // 将{翻译为"
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    // 将}翻译为"
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    // 将每个整数翻译为四位的十六进制形式, 然后加前缀"\\u"
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        // 假定不存存嵌套结构
        int value = Integer.parseInt(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
