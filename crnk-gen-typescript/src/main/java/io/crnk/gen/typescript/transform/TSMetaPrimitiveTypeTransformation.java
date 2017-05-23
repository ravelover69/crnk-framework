package io.crnk.gen.typescript.transform;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashMap;

import io.crnk.gen.typescript.model.TSAny;
import io.crnk.gen.typescript.model.TSElement;
import io.crnk.gen.typescript.model.TSPrimitiveType;
import io.crnk.gen.typescript.model.TSType;
import io.crnk.meta.model.MetaElement;
import io.crnk.meta.model.MetaPrimitiveType;

public class TSMetaPrimitiveTypeTransformation implements TSMetaTransformation {

	private HashMap<Class<?>, TSType> primitiveMapping;

	public TSMetaPrimitiveTypeTransformation() {
		primitiveMapping = new HashMap<>();
		primitiveMapping.put(Object.class, TSAny.INSTANCE);
		primitiveMapping.put(String.class, TSPrimitiveType.STRING);
		primitiveMapping.put(Boolean.class, TSPrimitiveType.BOOLEAN);
		primitiveMapping.put(boolean.class, TSPrimitiveType.BOOLEAN);
		primitiveMapping.put(long.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Long.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(float.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Float.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(double.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Double.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(int.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Integer.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(long.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Long.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(byte.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(Byte.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(BigDecimal.class, TSPrimitiveType.NUMBER);
		primitiveMapping.put(BigInteger.class, TSPrimitiveType.NUMBER);

		primitiveMapping.put(LocalDate.class, TSPrimitiveType.STRING);
		primitiveMapping.put(LocalDate.class, TSPrimitiveType.STRING);
		primitiveMapping.put(LocalDateTime.class, TSPrimitiveType.STRING);
		primitiveMapping.put(LocalDateTime.class, TSPrimitiveType.STRING);
		primitiveMapping.put(OffsetDateTime.class, TSPrimitiveType.STRING);
		primitiveMapping.put(OffsetDateTime.class, TSPrimitiveType.STRING);
		primitiveMapping.put(byte[].class, TSPrimitiveType.STRING);
	}

	@Override
	public boolean accepts(MetaElement element) {
		return element instanceof MetaPrimitiveType;
	}

	@Override
	public TSElement transform(MetaElement element, TSMetaTransformationContext context) {
		Class<?> implClass = ((MetaPrimitiveType) element).getImplementationClass();
		if (primitiveMapping.containsKey(implClass)) {
			return primitiveMapping.get(implClass);
		}
		throw new IllegalStateException("unexpected element: " + element);
	}
}