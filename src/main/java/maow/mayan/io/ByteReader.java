package maow.mayan.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteReader implements Closeable {
    private final ByteArrayInputStream bais;

    public ByteReader(Path path) throws IOException {
        if (Files.notExists(path)) {
            throw new FileNotFoundException();
        }
        this.bais = new ByteArrayInputStream(Files.readAllBytes(path));
    }

    public ByteReader(File file) throws IOException {
        this(file.toPath());
    }

    public ByteReader(ByteArrayInputStream bais) {
        if (bais == null) {
            throw new NullPointerException();
        }
        this.bais = bais;
    }

    public ByteReader(byte[] bytes) {
        this.bais = new ByteArrayInputStream(bytes);
    }

    public byte read() {
        return read(1)[0];
    }

    public byte[] read(int size) {
        return read(0, size);
    }

    public byte[] read(int offset, int size) {
        final byte[] buffer = new byte[size];
        final int len = bais.read(buffer, offset, size);
        if (len > -1) {
            return buffer;
        }
        return new byte[0];
    }

    @Override
    public void close() throws IOException {
        bais.close();
    }
}
