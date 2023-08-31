package bsp.traits;

import software.amazon.smithy.model.node.Node;
import software.amazon.smithy.model.node.ObjectNode;
import software.amazon.smithy.model.shapes.ShapeId;
import software.amazon.smithy.model.traits.AbstractTrait;
import software.amazon.smithy.model.traits.AnnotationTrait;

public class ExperimentalTrait extends AnnotationTrait {

    public static ShapeId ID = ShapeId.from("traits#experimental");

    public ExperimentalTrait(ObjectNode node) {
        super(ID, node);
    }

    public ExperimentalTrait() {
        super(ID, Node.objectNode());
    }

    public static final class Provider extends AbstractTrait.Provider {
        public Provider() {
            super(ID);
        }

        @Override
        public ExperimentalTrait createTrait(ShapeId target, Node node) {
            return new ExperimentalTrait(node.expectObjectNode());
        }
    }
}