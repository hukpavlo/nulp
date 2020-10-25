package task2;

abstract class Button {
    final int width;
    final int height;

    static{
        System.out.println("Button static initializer");
    }

    Button(int width, int height) {
        this.width = width;
        this.height = height;

        System.out.println("Button constructor");
    }
}

class RoundButton extends Button {
    final int borderRadius;

    static{
        System.out.println("RoundButton static initializer");
    }

    RoundButton(int width, int height, int borderRadius) {
        super(width, height);
        this.borderRadius = borderRadius;

        System.out.println("RoundButton constructor");
    }
}

class WindowsButton extends RoundButton {
    final double opacity;

    static{
        System.out.println("WindowsButton static initializer");
    }

    WindowsButton(int width, int height, int borderRadius, double opacity) {
        super(width, height, borderRadius);
        this.opacity = opacity;

        System.out.println("WindowsButton constructor");
    }
}