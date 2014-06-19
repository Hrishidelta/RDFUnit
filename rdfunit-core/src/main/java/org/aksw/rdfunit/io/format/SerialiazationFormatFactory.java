package org.aksw.rdfunit.io.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * User: Dimitris Kontokostas
 * Description
 * Created: 6/18/14 4:27 PM
 */
public class SerialiazationFormatFactory {
    public static Collection<SerializationFormat> getAllFormats() {
        ArrayList<SerializationFormat> serializationFormats = new ArrayList<>();

        serializationFormats.add(createTurtle());
        serializationFormats.add(createN3());
        serializationFormats.add(createNTriples());
        serializationFormats.add(createRDFXMLAbbrevOut());
        serializationFormats.add(createRDFXMLIn());
        serializationFormats.add(createRDFXMLOut());
        serializationFormats.add(createHTML());

        return serializationFormats;
    }

    public static SerializationFormat createHTML() {
        // HTML -> only output
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("html", "htm"));
        return new SerializationFormat(
                "html", SerializationFormatType.output, "html", "text/html", currentSynonyms);

    }

    public static SerializationFormat createTurtle() {
        // Turtle -> input & output
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("turtle", "ttl"));
        return new SerializationFormat(
                "TURTLE", SerializationFormatType.inputAndOutput, "ttl", "text/turtle", currentSynonyms);

    }

    public static SerializationFormat createN3() {
        // N3 -> input & output
        HashSet<String> currentSynonyms = new HashSet<>();
        return new SerializationFormat(
                "N3", SerializationFormatType.inputAndOutput, "n3", "rdf+n3", currentSynonyms);
    }

    public static SerializationFormat createNTriples() {
        // ntriples -> input & output
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("n-triple", "n-triples", "ntriple", "ntriples"));
        return new SerializationFormat(
                "N-TRIPLE", SerializationFormatType.inputAndOutput, "nt", "application/n-triples", currentSynonyms);

    }

    public static SerializationFormat createRDFXMLAbbrevOut() {
        // RDF/XML-ABBREV -> output only
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("RDF/XML-ABBREV", "RDF-XML-ABBREV", "RDFXMLABBREV"));
        return new SerializationFormat(
                "RDF/XML-ABBREV", SerializationFormatType.output, "rdf", "application/rdf+xml", currentSynonyms);
    }

    public static SerializationFormat createRDFXMLOut() {
        // RDF/XML -> output (split it to disambiguate abbrev)
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("RDF/XML", "RDF-XML", "RDFXML"));
        return new SerializationFormat(
                "RDF/XML", SerializationFormatType.output, "rdf", "application/rdf+xml", currentSynonyms);

    }

    public static SerializationFormat createRDFXMLIn() {
        // RDF/XML -> input
        HashSet<String> currentSynonyms = new HashSet<>();
        currentSynonyms.addAll(Arrays.asList("RDF/XML", "RDF-XML", "RDFXML", "RDF/XML-ABBREV", "RDF-XML-ABBREV", "RDFXML-ABBREV", "RDFXMLABBREV"));
        return new SerializationFormat(
                "RDF/XML", SerializationFormatType.input, "rdf", "application/rdf+xml", currentSynonyms);

    }
}
