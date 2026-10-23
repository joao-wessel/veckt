package com.veckt.backend.service.document;

import java.util.List;

public record ResolvedDocument(String content, List<String> unresolvedVariables) {}
