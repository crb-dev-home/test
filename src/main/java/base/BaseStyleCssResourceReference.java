package base;

import org.apache.wicket.request.resource.CssResourceReference;

/**
 * A simple stylesheet to fix some styles for the demo page.
 *
 * @author miha
 * @version 1.0
 */
public class BaseStyleCssResourceReference extends CssResourceReference {

    public static final BaseStyleCssResourceReference INSTANCE = new BaseStyleCssResourceReference();

    /**
     * Construct.
     */
    public BaseStyleCssResourceReference() {
        super(BaseStyleCssResourceReference.class, "style.css");
    }
}
