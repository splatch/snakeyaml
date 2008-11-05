/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package org.jvyaml;

import java.io.InputStream;
import java.io.Writer;

import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;

/**
 * @see PyYAML 3.06 for more information
 */
public class DefaultYAMLFactory implements YAMLFactory {
    public Scanner createScanner(final String io) {
        return new ScannerImpl(new org.yaml.snakeyaml.reader.Reader(io));
    }

    public Scanner createScanner(final InputStream io) {
        return new ScannerImpl(new org.yaml.snakeyaml.reader.Reader(io));
    }

    public Parser createParser(final Scanner scanner) {
        return new ParserImpl(scanner, new DefaultYAMLConfig());
    }

    public Parser createParser(final Scanner scanner, final YamlConfig cfg) {
        return new ParserImpl(scanner, cfg);
    }

    public Resolver createResolver() {
        return new ResolverImpl();
    }

    public Composer createComposer(final Parser parser, final Resolver resolver) {
        return new ComposerImpl(parser, resolver);
    }

    public Constructor createConstructor(final Composer composer) {
        return new ConstructorImpl(composer);
    }

    public Emitter createEmitter(final Writer output, final YamlConfig cfg) {
        return new EmitterImpl(output, cfg);
    }

    public Serializer createSerializer(final Emitter emitter, final Resolver resolver,
            final YamlConfig cfg) {
        return new SerializerImpl(emitter, resolver, cfg);
    }

    public Representer createRepresenter(final Serializer serializer, final YamlConfig cfg) {
        return new RepresenterImpl(serializer, cfg);
    }
}
